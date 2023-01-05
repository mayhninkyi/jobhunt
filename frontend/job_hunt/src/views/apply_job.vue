<template>
    <div>
        <v-container>
            <!-- Apply Job Form -->
            <v-form ref="applyJobForm" v-model="applyJobForm">


                <!-- Expected Salary-->
                <v-text-field v-model="salary" type="number" suffix="MMK" :rules="[
                    (v) => !!v || 'Required',
                ]" label="Expected Salary" required></v-text-field>
                <!--CV Video-->

                <v-file-input v-model="cvVideo" label="CV video" show-size prepend-icon="mdi-camera"
                    placeholder="Choose Video" accept="video/mp4" :rules="[
                        (v) => !!v || 'Required',
                        (v) =>
                            !v ||
                            v.size < 100000000 ||
                            'Image size should be less than 100 MB!',
                    ]" @change="onChangeVideo"></v-file-input>

                <video v-if="cvVideoPath != null" class="mb-2" width="100%" :src="cvVideoPath" controls></video>

                <!--cv form-->
                <v-file-input v-model="cvFile" label="CV Form" show-size prepend-icon="mdi-file"
                    placeholder="Choose File" accept="file/pdf" :rules="[
                        (v) => !!v || 'Required',
                        (v) =>
                            !v ||
                            v.size < 100000000 ||
                            'Image size should be less than 10 MB!',
                    ]" @change="onChangeFile"></v-file-input>

                <!-- Apply Btn -->
                <v-btn :disabled="!applyJobForm" color="blue-grey darken-3 white--text" class="mr-4"
                    @click="applyJob()">
                    <span v-if="!loading">APPLY JOB</span>
                    <v-progress-circular v-else indeterminate color="primary"></v-progress-circular>
                </v-btn>

                <!-- Error Alert -->
                <v-alert class="mt-3" v-show="errorAlert" dense type="error">
                    Apply Job Failed!
                </v-alert>
            </v-form>
        </v-container>
    </div>
</template>

<script>
import utils from "../utils/utils";

export default {
    name: "register",

    components: {},

    data() {
        return {
            applyJobForm: false,
            loginUser: {},
            cvFile: null,
            cvVideo: null,
            cvFormPath: null,
            cvVideoPath: null,
            expectedSalary: 0,
            errorAlert: false,
            loading: false,
            job_id: this.$route.params.id,
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
    },

    methods: {
        onChangeFile(cvFile) {
            this.cvFormPath = URL.createObjectURL(cvFile);
        },

        onChangeVideo(cvVideo) {
            this.cvVideoPath = URL.createObjectURL(cvVideo);
        },

        async applyJob() {
            if (this.$refs.applyJobForm.validate()) {
                this.errorAlert = false;

                try {
                    this.loading = true;

                    let respVideoData = null;
                    const respVideo = await utils.http.postMedia(
                        "/api/file/create",
                        this.cvVideo,
                        this.cvVideo.type
                    );
                    if (respVideo.status === 200) {
                        respVideoData = await respVideo.text();
                        console.log(respVideoData);
                    } else {
                        this.errorAlert = true;
                    }

                    let respFileData = null;
                    const respFile = await utils.http.postMedia(
                        "/api/file/create",
                        this.cvFile,
                        this.cvFile.type
                    );
                    if (respFile.status === 200) {
                        respFileData = await respFile.text();
                        console.log(respFileData);

                    } else {
                        this.errorAlert = true;
                    }

                    console.log(this.expectedSalary);
                    console.log(this.loginUser.id);


                    if (respVideoData && respFileData) {
                        // API Call
                        const resp = await utils.http.post("/api/applyJobs/create", {
                            cvFormPath: respFileData,
                            cvVideoPath: respVideoData,
                            expectedSalary: this.expectedSalary,
                            user: { id: this.loginUser.id },
                            job: { id: this.job_id },
                        });
                        if (resp.status === 200) {
                            const data = await resp.json();
                            if (data) {
                                console.log(data);
                                this.$router.push({ path: "/profile" });
                            }
                        } else {
                            this.errorAlert = true;
                        }
                    }


                } catch (error) {
                    console.log(error);
                } finally {
                    this.loading = false;
                }
            }
        },
    },
};
</script>
