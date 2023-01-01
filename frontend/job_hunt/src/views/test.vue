<template>
    <div>

        <v-row class="ma-0">
            <h1 class="mb-3">Created Jobs</h1>
            <v-spacer></v-spacer>
            <v-btn color="blue-grey darken-3 white--text" icon @click="onClickCreateBtn()">
                <v-icon size="30">mdi-plus-box</v-icon>
            </v-btn>
        </v-row>
        <v-data-table class="elevation-4" :headers="headers" :items="jobList" :items-per-page="5">
            <template v-slot:[`item.actions`]="{ item }">
                <v-btn class="mr-2" color="primary" fab x-small elevation="2" @click="editDialog = true; toUpdateJob = item;
">
                    <v-icon>mdi-pencil</v-icon>
                </v-btn>
                <v-btn color="red" fab dark x-small elevation="2" @click="deleteDialog = true; toDeleteJob = item;
">
                    <v-icon>mdi-delete</v-icon>
                </v-btn>
            </template>
        </v-data-table>


        <v-dialog v-model="deleteDialog" width="400">
            <v-card>
                <v-card-title class="blue-grey darken-3 white--text" primary-title>
                    Confirmation
                </v-card-title>

                <v-card-text class="mt-8">
                    {{ toDeleteJob.title }}
                </v-card-text>

                <v-card-text>
                    Are you sure to delete this job post ?
                </v-card-text>
                <v-card-actions class="justify-end">
                    <v-btn color="red" dark @click="deleteJob()">Delete</v-btn>
                </v-card-actions>
            </v-card>
        </v-dialog>

        <v-dialog v-model="editDialog" width="500">
            <v-card>
                <v-card-title class="blue-grey darken-3 white--text" primary-title>
                    Edit Job
                </v-card-title>
                <v-card-text class="mt-8">
                    <v-form ref="updateJobForm" v-model="updateJobForm">
                        <!-- Title -->
                        <v-text-field v-model="this.toUpdateJob.title" :counter="50" :rules="[
    (v) => !!v || 'Required',
    (v) =>
        (v && v.length <= 50) || 'Title must be less than 50 characters',
]" label="Title" required></v-text-field>

                        <!-- Description -->
                        <v-text-field v-model="this.toUpdateJob.description" :rules="[
    (v) => !!v || 'Required',
]" label="Description" required></v-text-field>

                        <!-- Requirement -->
                        <v-text-field v-model="this.toUpdateJob.requirement" :rules="[
    (v) => !!v || 'Required',
]" label="Requirement" required></v-text-field>

                        <!--No of Employee-->
                        <v-text-field v-model="this.toUpdateJob.noOfEmployee" type="number" :rules="[
    (v) => !!v || 'Required',
]" label="No: of Employee" required></v-text-field>

                        <!--Salary-->
                        <v-text-field v-model="this.toUpdateJob.salary" type="number" :rules="[
    (v) => !!v || 'Required',
]" label="Salary" required></v-text-field>

                        <!-- Category-->
                        <v-select v-model="this.toUpdateJob.category" :items="categoryList" item-text="name"
                            item-value="id" :rules="[(v) => !!v || 'Required']" label="Category" required>
                        </v-select>

                        <!-- Register Btn -->
                        <v-btn :disabled="!updateJobForm" color="blue-grey darken-3 white--text" class="mr-4"
                            @click="updateJob()">
                            <span v-if="!loading">UPDATE JOB</span>
                            <v-progress-circular v-else indeterminate color="primary"></v-progress-circular>
                        </v-btn>

                        <!-- Error Alert -->
                        <v-alert class="mt-3" v-show="errorAlert" dense type="error">
                            Update Job Failed!
                        </v-alert>
                    </v-form>
                </v-card-text>

            </v-card>
        </v-dialog>


    </div>
</template>
  
<script>
import utils from "../utils/utils";

export default {


    data() {
        return {
            localDomain: utils.constant.localDomain,
            loginUser: {},

            headers: [
                { text: "ID", value: "id", sortable: true },
                { text: "Title", value: "title", sortable: true },
                { text: "Description", value: "description", sortable: false },
                { text: "No of Employee", value: "noOfEmployee", sortable: true },
                { text: "salary", value: "salary", sortable: true },
                { text: "category", value: "category.name", sortable: false },
                { text: "CreatedAt", value: "createdAt", sortable: true },
                { text: "UpdatedAt", value: "updatedAt", sortable: false },
                { text: "Actions", value: "actions", sortable: false },
            ],
            jobList: [],

            deleteDialog: false,
            toDeleteJob: {},

            editDialog: false,
            updateJobForm: false,
            toUpdateJob: {
            },

            errorAlert: false,
            loading: false,

            categoryList: [],
        };
    },

    async created() {
        this.loginUser = this.$store.state.loginUser;
        this.$store.watch(
            () => {
                return this.$store.state.loginUser;
            },
            (newVal, oldVal) => {
                this.loginUser = newVal;
            },
            {
                deep: true,
            }
        );
        await this.fetchJobCategories();
        await this.fetchJobByCompany();

    },

    methods: {
        async fetchJobByCompany() {
            const resp = await utils.http.get("/api/job/company/" + this.loginUser.id);
            if (resp.status === 200) {
                const data = await resp.json();
                if (data) {
                    this.jobList = data;
                }
            }
        },

        async fetchJobCategories() {
            const resp = await utils.http.get("/api/category");
            if (resp.status === 200) {
                const data = await resp.json();
                if (data) {
                    this.categoryList = data;
                }
            }
        },

        async deleteJob() {
            const resp = await utils.http.del(
                "/api/job/delete/" + this.toDeleteJob.id
            );
            if (resp.status === 200) {
                this.deleteDialog = false;
                await this.fetchJobByCompany();
            } else {
                this.errorAlert = true;
            }
        },

        async updateJob() {
            if (this.$refs.updateJobForm.validate()) {
                this.errorAlert = false;
                this.loading = true;

                const result = await utils.http.put(
                    "/api/job/update/" + this.toUpdateJob.id,
                    {
                        "title": this.toUpdateJob.title,
                        "description": this.toUpdateJob.description,
                        "requirement": this.toUpdateJob.requirement,
                        "noOfEmployee": this.toUpdateJob.noOfEmployee,
                        "salary": this.toUpdateJob.salary,
                        "isCloseJob": false,
                        "company": { "id": this.loginUser.id },
                        "category": { "id": this.toUpdateJob.category.id }
                    }
                );
                if (result.status === 200) {
                    this.editDialog = false;
                    await this.fetchJobByCompany();
                } else {
                    this.errorAlert = true;
                }

                this.loading = false;
            }
        },

        onClickCreateBtn() {
            this.$router.push({ path: "/create_job" });
        }
    },
};
</script>
  