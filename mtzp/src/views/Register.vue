<template>
    <div>
        <v-container>
            <v-card class="pa-5 mt-7" elevation="6" max-width="800">
                <v-card-title  >Sign Up To Create A JubHunt Profile</v-card-title>
        <!-- Form -->
        <v-form ref="registerform">
            <!-- Name Text Field -->
            <v-text-field 
            v-model="name" 
            label="Name"
            placeholder="Mg Mg"
            :rules="[(v) => !!v || 'Required']"
            required
            ></v-text-field>
            <!-- Mail Address Text Field -->
            <v-text-field 
            v-model="email" 
            label="E-Mail"
            placeholder="test@email.com"
            :rules="[(v) => !!v || 'Required']"
            required
            ></v-text-field>
            <!-- Age Text Field -->
            <!-- <v-text-field 
            v-model="age" 
            label="Age"
            placeholder="10"
            type="number"
            :rules="[
            (v) => !!v || 'Required',
            (v) => (v && v > 0) || 'Age must be register than 0',
            (v) => (v && v <= 200) || 'Age must be less than 100',
            ]"
            required
            ></v-text-field> -->
            <!-- Gender Select -->
            <v-select
            v-model="gender"
             :items="['unknown','mail','femal']" 
             label="Gender"
             :rules="[(v) => !!v || 'Required']"
            required
            > </v-select>
            <!-- Selt Introduction Textarea -->
             <v-textarea
             v-model="selfIntro"
              label="Self Introduction"
              clearable 
              counter 
              :rules= "[
                (v) => 
                (v && v.length <= 200) || 'Self Introduction be less than 200',
              ]"
              > </v-textarea>

              <v-btn color="success" @click="onClickRegisterBtn"> Register</v-btn>
         </v-form>
        </v-card>
        </v-container>
    </div>
  
</template>

<script>
export default {
    name:'register',
    data() {
        return{
            name:'',
            email:'',
            age: 0,
            gender: '',
            selfIntro: '',

            // name:'Mg Mg',
            // email:'mg@gmail.com',
            // age: 20,
            // gender: 'mail',
            // selfIntro: 'test',
        };

    },
    methods: {
        onClickRegisterBtn() {
            if(this.$refs.registerform.validate()){
                // console.log("Validate Successful");
                // console.log(this.name);
                // console.log(this.email);
                // console.log(this.age);
                // console.log(this.gender);
                // console.log(this.selfIntro);

                // Store in vuex state
                this.$store.commit('setIsRegister', true);
                this.$store.commit('setUserInfo', {
                    name: this.name,
                    email: this.email,
                    age: this.age,
                    gender: this.gender,
                    selfIntro: this.seltIntro,
                });

                // Go to router
                this.$router.push({ path: '/'});


            } else {
                console.log("Validate Failed");

            }
        },
    },
  

};
</script>

<style>

</style>