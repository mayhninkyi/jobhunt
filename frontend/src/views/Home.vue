<template>
  <h1>Welcome To Home {{ userInfo.name }}</h1>
</template>

<script>
export default {
    name: 'home',
    data() {
      return{
        userInfo: {},

      };

    },
    created() {
      // console.log(this.$router.currentRoute.path);
      this.userInfo = this.$store.state.userInfo;
      this.$store.watch(
      () => {
        return this.$store.state.userInfo;
      },
      (newVal, oldVal) => {
        this.userInfo = newVal;
      },
      {
        deep: true,
      }
    );
    },

};
</script>

<style>

</style>