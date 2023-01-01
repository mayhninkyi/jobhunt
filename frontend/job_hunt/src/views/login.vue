<template>
  <div>
    <v-container>
      <!-- Login Form -->
      <v-form ref="loginForm" v-model="loginForm">
        <!-- Email -->
        <v-text-field v-model="email" :rules="[
  (v) => !!v || 'Required',
  (v) => /.+@.+\..+/.test(v) || 'E-mail must be valid',
]" label="E-mail" required></v-text-field>

        <!-- Password -->
        <v-text-field v-model="password" :counter="10" :rules="[
  (v) => !!v || 'Required',
  (v) =>
    (v && v.length <= 10) ||
    'Password must be less than 10 characters',
]" label="Password" required></v-text-field>

        <!-- Login Btn -->
        <v-btn :disabled="!loginForm" color="blue-grey darken-3 white--text" class="mr-4" @click="login()">
          <span v-if="!loading">Login</span>
          <v-progress-circular v-else indeterminate color="primary"></v-progress-circular>
        </v-btn>

        <!-- Error Msg -->
        <v-alert class="mt-3" v-show="errorAlert" dense type="error">
          Login Failed! <br />
          Email or Password is wrong!
        </v-alert>
      </v-form>
    </v-container>
  </div>
</template>

<script>
import utils from "../utils/utils";

export default {
  name: "login",

  components: {},

  data() {
    return {
      loginForm: false,
      email: "",
      password: "",
      errorAlert: false,
      loading: false,
    };
  },

  async created() { },

  methods: {
    async login() {
      if (this.$refs.loginForm.validate()) {
        this.errorAlert = false;

        try {
          this.loading = true;

          // API Call
          const resp = await utils.http.post("/api/user/login", {
            gmail: this.email,
            password: this.password,
          });
          if (resp && resp.status === 200) {
            const data = await resp.json();
            if (data) {
              // Store Login Info in Vuex
              this.$store.commit("setLoginUser", data);
              this.$router.push({ path: "/" });
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
