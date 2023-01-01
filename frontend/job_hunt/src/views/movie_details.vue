<template>
  <div class="my-5 container">
    <!-- Poster, Movie Info -->
    <v-row class="ma-0">
      <!-- Poster -->
      <v-col cols="3" class="ma-0 pa-0">
        <v-img
          class="ma-0"
          :src="localDomain + movie.posterPath"
          contain
        ></v-img>
      </v-col>

      <!-- Movie Info -->
      <v-col cols="7">
        <div class="text-h3">{{ movie.title }}</div>
        <div class="text-caption ml-2 my-2">{{ movie.category.name }}</div>
        <div class="text-body-1 ml-2 my-2">{{ movie.budget }} Kyat</div>
        <div v-show="movie.adult" class="text-body-1 ml-2 my-2">Adult</div>
        <v-card class="text-body-1 ml-1 my-2 pa-2">{{ movie.overview }}</v-card>
      </v-col>
    </v-row>

    <!-- Trailer -->
    <div class="mx-2 mt-5">
      <h3 class="mb-3">Trailer</h3>
      <video
        class="mb-2"
        width="100%"
        :src="localDomain + movie.trailerPath"
        controls
      ></video>
    </div>
  </div>
</template>

<script>
import utils from "../utils/utils";

export default {
  name: "movie_details",

  data() {
    return {
      localDomain: utils.constant.localDomain,

      loginUser: {},

      // Movie ID from Path
      movie_id: this.$route.params.id,
      movie: {},
    };
  },

  async created() {
    // LoginUser from Vuex
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

    await this.fetchMovie();
    await this.recordMovieHistory();
  },

  methods: {
    async fetchMovie() {
      const resp = await utils.http.get("/movie/" + this.movie_id);
      if (resp && resp.status === 200) {
        const data = await resp.json();
        if (data) {
          this.movie = data;
        }
      }
    },
    async recordMovieHistory() {
      const resp = await utils.http.post("/record/add", {
        user: {
          id: this.loginUser.id,
        },
        movie: {
          id: this.movie_id,
        },
      });
      if (resp && resp.status !== 200) {
        console.log("Record Movie History Failed!");
      }
    },
  },
};
</script>

<style scoped>
.container {
  margin-left: 10vw !important;
  margin-right: 10vw !important;
}
</style>
