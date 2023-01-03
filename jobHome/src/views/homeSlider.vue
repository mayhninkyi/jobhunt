<template>
    <div id="app">
      <Slider />
      <p></p>
      <p></p>
      <p></p>

      <v-card elevation="4"
      height="430px"
      width="800px"
      class="mx-auto"
    >
  
      <v-list two-line>
        <template v-for="(item, index) in items">
          <v-subheader 
            v-if="item.header"
            :key="item.header"
            v-text="item.header"
          ></v-subheader>
  
          <v-divider
            v-else-if="item.divider"
            :key="index"
            :inset="item.inset"
          ></v-divider>
  
          <v-list-item
            v-else
            :key="item.title"
          >
            <v-list-item-avatar>
              <v-img :src="item.avatar" height="37" width="37"></v-img>
            </v-list-item-avatar>
  
            <v-list-item-content>
              <v-list-item-title v-html="item.title"></v-list-item-title>
              <!-- <v-list-item-subtitle v-html="item.subtitle"></v-list-item-subtitle> -->
            </v-list-item-content>
          </v-list-item>
        </template>
      </v-list>
    </v-card>
      <p></p>
      <p></p>
      <p></p>
      
    <v-card elevation="4"
      height="320px"
      max-width="400"
      class="mx-auto"
    >
    <v-toolbar
    color="cyan"
    light
    >

      <v-toolbar-title>Job Category</v-toolbar-title>

      <v-spacer></v-spacer>

      <v-btn icon>
        <v-icon>mdi-magnify</v-icon>
      </v-btn>
    </v-toolbar>
    <v-list
      flat
      subheader
      single-line
    >
      <!-- <v-subheader>Job Category</v-subheader> -->

      <v-list-item-group
        v-model="settings"
        multiple
        active-class=""
      >
        <v-list-item>
          <template v-slot:default="{ active }">
            <v-list-item-action>
              <v-checkbox :input-value="active"></v-checkbox>
            </v-list-item-action>

            <v-list-item-content>
              <v-list-item-title>Engineering</v-list-item-title>
              <!-- <v-list-item-subtitle>Notify me about updates to apps or games that I downloaded</v-list-item-subtitle> -->
            </v-list-item-content>
          </template>
        </v-list-item>

        <v-list-item>
          <template v-slot:default="{ active }">
            <v-list-item-action>
              <v-checkbox :input-value="active"></v-checkbox>
            </v-list-item-action>

            <v-list-item-content>
              <v-list-item-title>Software Engineer</v-list-item-title>
              <!-- <v-list-item-subtitle>Auto-update apps at any time. Data charges may apply</v-list-item-subtitle> -->
            </v-list-item-content>
          </template>
        </v-list-item>

        <v-list-item>
          <template v-slot:default="{ active }">
            <v-list-item-action>
              <v-checkbox :input-value="active"></v-checkbox>
            </v-list-item-action>

            <v-list-item-content>
              <v-list-item-title>System Engineer</v-list-item-title>
              <!-- <v-list-item-subtitle>Automatically add home screen widgets when downloads complete</v-list-item-subtitle> -->
            </v-list-item-content>
          </template>
        </v-list-item>

        <v-list-item>
          <template v-slot:default="{ active }">
            <v-list-item-action>
              <v-checkbox :input-value="active"></v-checkbox>
            </v-list-item-action>

            <v-list-item-content>
              <v-list-item-title>Web Developer</v-list-item-title>
              <!-- <v-list-item-subtitle>Automatically add home screen widgets when downloads complete</v-list-item-subtitle> -->
            </v-list-item-content>
          </template>
        </v-list-item>

        <v-list-item>
          <template v-slot:default="{ active }">
            <v-list-item-action>
              <v-checkbox :input-value="active"></v-checkbox>
            </v-list-item-action>
        <v-list-item-content>
              <v-list-item-title>Dev Ops Engineer</v-list-item-title>
              <!-- <v-list-item-subtitle>Automatically add home screen widgets when downloads complete</v-list-item-subtitle> -->
            </v-list-item-content>
          </template>
        </v-list-item>

      </v-list-item-group>
    </v-list>
  </v-card>
    </div> 
  </template>
  
  <script>
  import Slider from "../components/Slider.vue";
  export default {
    name: "app",
    components: {
      Slider
    },
    disabled:"false",

    data: () => ({
    items: [
      { header: 'Top Employers' },
      {
        avatar: 'https://www.jobnet.com.mm/image/o9SXyF4kPWv_4nhtaCnNLKCh5ySN9sCJXHtUyYHC3oh1KUfU89wdSi4PQWM-UTJr8tKbW9-1rVanrunSEFMCZxI1_9AazD1Qk9HeZMGgQD1QuAiH3SVxbA==',
        title: 'Ananda Digital Myanmar',
        // subtitle: `<span class="text--primary">Ali Connors</span> &mdash; I'll be in your neighborhood doing errands this weekend. Do you want to hang out?`,
      },
      { divider: true, inset: true },
      {
        avatar: 'https://www.jobnet.com.mm/image/o9SXyF4kPWv_4nhtaCnNLKCh5ySN9sCJXHtUyYHC3oiWeE__v87G0aEzl78hQIOyvTzH99WTzFiGLjxJCWxGyA==',
        title: 'Yoma Bank',
        // subtitle: `<span class="text--primary">to Alex, Scott, Jennifer</span> &mdash; Wish I could come, but I'm out of town this weekend.`,
      },
      { divider: true, inset: true },
      {
        avatar: 'https://www.jobnet.com.mm/image/o9SXyF4kPWv_4nhtaCnNLKCh5ySN9sCJXHtUyYHC3ojNw2EdE55KmMyi-uvqN6oS1wvkoV_2BVtPoCFZlIo7jw==',
        title: 'Unilever Myanmar Group',
        // subtitle: '<span class="text--primary">Sandra Adams</span> &mdash; Do you have Paris recommendations? Have you ever been?',
      },
      { divider: true, inset: true },
      {
        avatar: 'https://www.jobnet.com.mm/image/o9SXyF4kPWv_4nhtaCnNLKCh5ySN9sCJtJ7ZEKpaHBU8iktuj9iZ91Cudz2vf6p26IBhIGuKzYOjTfHGGcV-Rg==',
        title: 'Coca-Cola Pinya Beverages Myanmar',
        // subtitle: '<span class="text--primary">Trevor Hansen</span> &mdash; Have any ideas about what we should get Heidi for her birthday?',
      },
      { divider: true, inset: true },
      {
        avatar: 'https://www.jobnet.com.mm/image/o9SXyF4kPWv_4nhtaCnNLKCh5ySN9sCJtJ7ZEKpaHBUmpcCDNSLn-OTLAMXnwXehwRdiwZBiru6zuqitUxhnjIDXs4jKdBeA',
        title: 'Carlsberg Myanmar',
        // subtitle: '<span class="text--primary">Britta Holt</span> &mdash; We should eat this: Grate, Squash, Corn, and tomatillo Tacos.',
      },
    ],
  }),
  };
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