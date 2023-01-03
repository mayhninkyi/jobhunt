<template>
  <div>
    <v-container fluid>
      <v-row dense>
        <v-col
          v-for="card in cards"
          :key="card.title"
          :cols="card.flex"
        >
            <v-img
              :src="card.src"
              class="white--text align-end"
              gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)"
              height="400px"
            >
              <v-card-title v-text="card.title"></v-card-title>
            </v-img>

        </v-col>
      </v-row>
    </v-container>

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

<v-container> 
<v-card elevation="4">
  <v-simple-table
    fixed-header
    height="200px"
  >
    <template v-slot:default>
      <thead>
        <tr>
          <th class="text-left">
            COMPANIES
          </th>
          <th class="text-left">
            <i class="icon-font icon-star"></i>
            <i class="icon-font icon-star"></i>
          TOP JOBS
          </th>
          <th class="text-left">
            LEADING EMPLOYERS
          </th>
        </tr>
      </thead>

      <tbody>
        <!-- <tr
          v-for="item in desserts"
          :key="item.name"
        >
          <td>{{ item.name }}</td>
          <td>{{ item.calories }}</td>
          <td>{{ item.calories }}</td>
        </tr> -->

        <tr>
          <td><p>vue test</p></td>
          <td><p>vue test</p></td>
          <td><p>vue test</p></td>
        </tr>
        <tr>
          <td><p>vue test</p></td>
          <td><p>vue test</p></td>
          <td><p>vue test</p></td>
        </tr>
        <tr>
          <td><p>vue test</p></td>
          <td><p>vue test</p></td>
          <td><p>vue test</p></td>
        </tr>
        <tr>
          <td><p>vue test</p></td>
          <td><p>vue test</p></td>
          <td><p>vue test</p></td>
        </tr>
        <tr>
          <td><p>vue test</p></td>
          <td><p>vue test</p></td>
          <td><p>vue test</p></td>
        </tr>
      </tbody>
    </template>
  </v-simple-table>
  </v-card>
</v-container>
</div>
</template>


<script>
// import api from "../utils/api.js";

export default {
  name: "Home",

  components: {},


    data: () => ({
      cards: [
        { title: 'Pre-fab homes', src: 'https://cdn.vuetifyjs.com/images/cards/house.jpg', flex: 12 },
        // { title: 'Favorite road trips', src: 'https://cdn.vuetifyjs.com/images/cards/road.jpg', flex: 6 },
        // { title: 'Best airlines', src: 'https://cdn.vuetifyjs.com/images/cards/plane.jpg', flex: 6 },
      ],
    }),
  }
</script>

