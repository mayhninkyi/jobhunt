<template>
  <div>
    <v-card class="mx-auto pa-3" max-width="344">
      <v-card-text>
        <div>Weclome</div>
        <p class="text-h4 text--primary">
          {{ loginUser.name }}
        </p>
        <div class="text--primary">
          <div>{{ loginUser.gmail }}</div>
        </div>
      </v-card-text>
      <v-btn text color="teal accent-4" @click="editProfile">
        Edit Profile
      </v-btn>
      <v-btn text color="teal accent-4" @click="changePwd">
        Change Password
      </v-btn>
      <v-btn text color="teal accent-4" @click="appliedUsers">
        See Your Applied Users
      </v-btn>
    </v-card>
  </div>
</template>

<script>

export default {
  name: "profile",
  data() {
    return {
      loginUser: {},
    };
  },
  created() {
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
    changePwd() {
      this.$router.push({ path: "/changePwd" });
    },

    editProfile() {
      this.$router.push({ path: "/user_profile" });
    },

    appliedUsers() {
      this.$router.push({ path: "/profile" });
    },
  },
};
</script>
