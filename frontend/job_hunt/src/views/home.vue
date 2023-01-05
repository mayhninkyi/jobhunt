<template>
  <div>
    <v-row>
      <!-- Category Menu -->
      <v-col cols="2">
        <div class="section1">
          <p class="sidebar-title ">Categories</p>
          <ul v-for="item in categoryList" :key="item">
            <li @click="onClickCategory(item)">{{ item.name }}</li>
          </ul>
        </div>
      </v-col>

      <!-- Job List -->
      <v-col cols="10">
        <v-row>
          <v-col cols="3" v-for="(job, index) in jobList" :key="index">
            <v-card @click="goToJobDetails(job)" height="390">
              <v-card-text>
                <v-img :src="image" max-height="350" cover></v-img>
                <div class="text-h6">{{ job.company.name }}</div>
                <div class="text-body-1">{{ job.title }}</div>
                <div class="text-body-1">{{ job.description }} </div>
                <div class="text-body-1">{{ job.salary }} MMK</div>
                <div v-show="job.isCloseJob" class="text-body-1">Closed</div>
                <v-spacer></v-spacer>
                <v-btn color="blue-grey darken-3 white--text" class="mr-4" @click="createJob()">
                  <span>DETAIL</span>
                </v-btn>
              </v-card-text>
            </v-card>
          </v-col>
        </v-row>
      </v-col>
    </v-row>
  </div>
</template>

<script>
import utils from "../utils/utils";
export default {
  name: "home",

  components: {},

  data() {
    return {
      localDomain: utils.constant.localDomain,

      jobList: [],

      categoryList: [],
      image: "https://image.shutterstock.com/image-photo/beautiful-cosmos-flowers-blooming-garden-260nw-797194879.jpg"
    };
  },

  async created() {
    await this.fetchCategory();
    await this.fetchJobs();
  },

  methods: {
    async fetchJobs() {
      const resp = await utils.http.get("/api/job");
      if (resp && resp.status === 200) {
        const data = await resp.json();
        if (data) {
          this.jobList = data;
        }
      }
    },

    async fetchCategory() {
      const resp = await utils.http.get("/api/category");
      if (resp.status === 200) {
        const data = await resp.json();
        if (data) {
          this.categoryList = data;
        }
      }
    },

    goToJobDetails(job) {
      this.$router.push({
        path: "/job_detail/" + job.id,
      });
    },

    async onClickCategory(cat) {
      const resp = await utils.http.get("/api/job/category/" + cat.id);
      if (resp && resp.status === 200) {
        const data = await resp.json();
        if (data) {
          this.jobList = data;
        }
      }
    },
  },
};
</script>

<style>
.card {
  flex: 0 0 30%;
  margin: 10px;
}

.sidebar-title {
  text-align: center;
  font-size: 20px;
  margin-top: 25px;
  font-weight: bold;
}

.section1>ul {
  list-style-type: none;
  text-align: center;
}

.section1>ul:hover {
  border: 1px solid #000;
  background-color: #000;
  color: #fff;
}

.section1>ul {
  border: 1px solid rgb(168, 165, 165);
  margin-left: 25px;
  margin-bottom: 10px;
  padding: 5px;
  border-radius: 25px;
}
</style>