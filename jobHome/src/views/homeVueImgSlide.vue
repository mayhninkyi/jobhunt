<template>
    <div id="app">
      <vue-image-slider :images="imageArray" :intervalVal=3000 :height=520 :width=1440 />

      <v-container>
      <v-card-title>Top Employers</v-card-title>
      <v-card elevation="4">
    <v-rol dense>
        <v-col>
      <v-img
        height="50"
        width="50"
        src="https://cdn.vuetifyjs.com/images/cards/cooking.png"
      ></v-img>
      <v-card-title>Cafe Badilico</v-card-title>
    </v-col>
  
    <v-col>
      <v-img
      height="50"
        width="50"
        src="https://cdn.vuetifyjs.com/images/cards/cooking.png"
      ></v-img>
      <v-card-title>Cafe Badilico</v-card-title>
    </v-col>
    </v-rol>
    </v-card>
  </v-container>
  
  </div>
  </template>
  
  <script>
  import VueImageSlider from 'vue-image-slider'
   
  export default {
   name: 'app',
   components: {
    VueImageSlider
   },
   data() {
    return {
     imageArray: [
      'https://cdn.pixabay.com/photo/2015/12/12/15/24/amsterdam-1089646_1280.jpg',
      'https://cdn.pixabay.com/photo/2016/02/17/23/03/usa-1206240_1280.jpg',
      'https://cdn.pixabay.com/photo/2015/05/15/14/27/eiffel-tower-768501_1280.jpg',
      'https://cdn.pixabay.com/photo/2016/12/04/19/30/berlin-cathedral-1882397_1280.jpg'
     ],
    }
   },
  }
  </script>
  
  <style>
  #app {
    font-family: "Avenir", Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
  }
  body {
    margin: 0px;
  }
  </style>
  