<template>
    <div>
      <v-container>
        <!-- Edit user profile Form -->
        <v-form ref="updateForm" v-model="updateForm">
          <!-- Name -->
          <v-text-field
            v-model="loginUser.name"
            :disabled="true"           
            label="Name"
          ></v-text-field>
  
          <!-- Email -->
          <v-text-field
            v-model="loginUser.gmail"
            :disabled="true"
            :rules="[
              (v) => !!v || 'Required',
              (v) => /.+@.+\..+/.test(v) || 'E-mail must be valid',
            ]"
            label="E-mail"
          ></v-text-field>

          <!--profile-->
          <v-file-input
            v-model="profile"
            label="Profile Image"
            show-size
            prepend-icon="mdi-camera"
            placeholder="Choose Profile Image"
            accept="image/png, image/jpeg"
            :rules="[
              (v) => !!v || 'Required',
              (v) =>
                !v ||
                v.size < 10000000 ||
                'Image size should be less than 10 MB!',
            ]"
            @change="onChangeProfile"
          ></v-file-input>

          <v-img
            v-if="loginUser.profilePath != null"
            :src="loginUser.profilePath"
            width="200"
            height="150"
            contain
          >
          </v-img>

          <!--Phone-->
          <v-text-field
          v-model="loginUser.phone"
          :counter="11"
          type="number"
          :rules="[
            (v) => !!v || 'Required',
            (v) =>
              (v && v.length <= 11) || 'Please Enter a Valid Phone No',
          ]"
          label="Phoe No"
          required
        ></v-text-field>



           <!-- Address -->
        <v-text-field
          v-model="loginUser.address"
          :counter="100"
          :rules="[
            (v) => !!v || 'Required',
            (v) =>
              (v && v.length <= 100) || 'Address must be less than 100 characters',
          ]"
          label="Address"
          required
        ></v-text-field>



          <!--about-->
          <v-text-field
          v-model="loginUser.about"
          :counter="100"
          :rules="[
            (v) => !!v || 'Required',
            (v) =>
              (v && v.length <= 100) || 'About must be less than 100 characters',
          ]"
          label="About"
          required
        ></v-text-field>



         
  
          
  
         
  
          <!-- Update Btn -->
          <v-btn
            color="blue-grey darken-3 white--text"
            class="mr-4"
            @click="update()"
          >
            <span v-if="!loading">Update</span>
            <v-progress-circular
              v-else
              indeterminate
              color="primary"
            ></v-progress-circular>
          </v-btn>
  
          <!-- Error Alert -->
          <v-alert class="mt-3" v-show="errorAlert" dense type="error">
            Update Profile Failed!
          </v-alert>
        </v-form>
      </v-container>
    </div>
  </template>
  
  <script>
  import utils from "../utils/utils";
  
  export default {
    name: "user profile",
  
    components: {},
  
    data() {
      return {
        profile: null,
        loginUser: {},
        updateForm: false,
        errorAlert: false,
      loading: false,
  
        
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
      onChangeProfile(profile) {
      this.loginUser.profilePath = URL.createObjectURL(profile);
    },
    
      async update() {
        console.log(this.loginUser.pr);
        if (this.$refs.updateForm.validate()) {
          this.errorAlert = false;
  
          try {
            this.loading = true;
  
            // API Call
            const resp = await utils.http.put("/api/user/update", {
              id: this.loginUser.id,
              name: this.loginUser.name,
              gmail: this.loginUser.gmail,
              password: this.loginUser.password,
              profilePath:this.loginUser.profilePath,
              status:this.loginUser.status,
              role:this.loginUser.role,
              about:this.loginUser.about,
              address:this.loginUser.address,
              phone:this.loginUser.phone,
              createdAt:this.loginUser.createdAt,
            });
            if (resp.status === 200) {
              const data = await resp.json();
              console.log(data);
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
  