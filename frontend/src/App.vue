<template>
  <v-app>
    <v-main>
    <!-- Nar Bar -->
      <v-app-bar color="deep-purple accent-4" dark>
      <v-btn text @click="gotoScreen('/')">Home</v-btn>
      <v-spacer></v-spacer>
      <v-btn v-show="!isRegister" @click="gotoScreen('/register')"> Register </v-btn>
      <v-btn v-show="isRegister" @click="gotoScreen('/profile')"> Profile </v-btn>
      <v-btn text @click="gotoScreen('/about')"> About </v-btn>
      <v-btn text v-show="isRegister" @click="onClickLogout"> Logout </v-btn>
      </v-app-bar>
      <!-- Screen -->
    <v-container>
      <router-view/>
    </v-container>
  
   
    </v-main>
  </v-app>
</template>

<script>

export default {
  name: 'App',

  data: () => ({
    isRegister: false,
  }),
  created(){
    this.isRegister = this.$store.state.isRegister;
    this.$store.watch(
      () => {
        return this.$store.state.isRegister;
      },
      (newVal, oldVal) => {
        this.isRegister = newVal;

      },
      {
        deep: true,
      }
    );
  },
  methods: {
    onClickLogout(){
          // Store in vuex state
          this.$store.commit('setIsRegister', false);
          this.$store.commit('setUserInfo', {});

          // Go to Home
          if (this.$router.currentRoute.path != "/") {
            this.gotoScreen('/');

          }
          
    },
    
    gotoScreen(screenPath) {
      this.$router.push({ path:screenPath });

    },
  },
};
</script>
