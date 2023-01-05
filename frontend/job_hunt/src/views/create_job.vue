<template>
  <div>
    <v-container>
      <!-- Create Job Form -->
      <v-form ref="createJobForm" v-model="createJobForm">
        <!-- Title -->
        <v-text-field v-model="title" :counter="50" :rules="[
  (v) => !!v || 'Required',
  (v) =>
    (v && v.length <= 50) || 'Title must be less than 50 characters',
]" label="Title" required></v-text-field>

        <!-- Description -->
        <v-text-field v-model="description" :rules="[
  (v) => !!v || 'Required',
]" label="Description" required></v-text-field>

        <!-- Requirement -->
        <v-text-field v-model="requirement" :rules="[
  (v) => !!v || 'Required',
]" label="Requirement" required></v-text-field>

        <!--No of Employee-->
        <v-text-field v-model="noOfEmployee" type="number" :rules="[
  (v) => !!v || 'Required',
]" label="No: of Employee" required></v-text-field>

        <!--Salary-->
        <v-text-field v-model="salary" type="number" :rules="[
  (v) => !!v || 'Required',
]" label="Salary" required></v-text-field>

        <!-- Category-->
        <v-select v-model="category" :items="categoryList" item-text="name" item-value="id"
          :rules="[(v) => !!v || 'Required']" label="Category" required>
        </v-select>

        <!-- Register Btn -->
        <v-btn :disabled="!createJobForm" color="blue-grey darken-3 white--text" class="mr-4" @click="createJob()">
          <span v-if="!loading">CREATE JOB</span>
          <v-progress-circular v-else indeterminate color="primary"></v-progress-circular>
        </v-btn>

        <!-- Error Alert -->
        <v-alert class="mt-3" v-show="errorAlert" dense type="error">
          Create Job Failed!
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
      createJobForm: false,
      loginUser: {},
      title: "",
      description: "",
      requirement: "",
      categoryList: [],
      noOfEmployee: 1,
      salary: 0,
      category: 1,
      errorAlert: false,
      loading: false,
    };
  },

  async created() {
    await this.fetchCategory();
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
    async fetchCategory() {
      const resp = await utils.http.get("/api/category");
      if (resp.status === 200) {
        const data = await resp.json();
        if (data) {
          this.categoryList = data;
        }
      }
    },
    async createJob() {
      if (this.$refs.createJobForm.validate()) {
        this.errorAlert = false;

        try {
          this.loading = true;

          // API Call
          const resp = await utils.http.post("/api/job/create", {
            title: this.title,
            description: this.description,
            requirement: this.requirement,
            noOfEmployee: this.noOfEmployee,
            salary: this.salary,
            isCloseJob: false,
            company: { id: this.loginUser.id },
            category: { id: this.category },
          });
          if (resp.status === 200) {
            const data = await resp.json();
            if (data) {
              console.log(data);
              this.$router.push({ path: "/created_jobs" });
            }
          } else {
            this.errorAlert = true;
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
  