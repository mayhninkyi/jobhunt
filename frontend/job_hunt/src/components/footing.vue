<template>
  <v-footer
    :padless="true"
  >
    <v-card
      flat
      tile
      width="100%"
      class="blue-grey darken-3 white--text text-center"
    >
      <v-card-text>
        <v-btn
          class="mx-4 white--text"
          icon
        >
          <v-icon size="24px">mdi-facebook</v-icon>
        </v-btn>
        <v-btn
          class="mx-4 white--text"
          icon
        >
          <v-icon size="24px">mdi-email</v-icon>
        </v-btn>
        <v-btn
          class="mx-4 white--text"
          icon
        >
          <v-icon size="24px">mdi-phone-classic</v-icon>
        </v-btn>
        

      </v-card-text>

      <v-card-text class="white--text pt-0">
        Phasellus feugiat arcu sapien, et iaculis ipsum elementum sit amet. Mauris cursus commodo interdum. Praesent ut risus eget metus luctus accumsan id ultrices nunc. Sed at orci sed massa consectetur dignissim a sit amet dui. Duis commodo vitae velit et faucibus. Morbi vehicula lacinia malesuada. Nulla placerat augue vel ipsum ultrices, cursus iaculis dui sollicitudin. Vestibulum eu ipsum vel diam elementum tempor vel ut orci. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.
      </v-card-text>

      <v-divider></v-divider>

      <v-card-text class="blue-grey darken-3 white--text">
        {{ new Date().getFullYear() }} — <strong>Copyright @2022 JobHunt.com.mm</strong>
      </v-card-text>
    </v-card>
  </v-footer>
</template>

<script>
export default {
  name: "footing",

  data: () => ({}),
};
</script>

<style scoped>
.text-white {
  color: white !important;
}
</style>
