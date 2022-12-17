<template>
  <div>
    <v-container>
        <v-card class="pa-5 mt-7" elevation="4" max-width="300">
            <v-img
            max-height="150"
           
            src="https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Image_created_with_a_mobile_phone.png/640px-Image_created_with_a_mobile_phone.png"
            ></v-img>
            <v-card-title>About This Page</v-card-title>
            <v-card-text>Our Jobs Hunb Serve... </v-card-text>
            <v-card-actions>
                <v-btn color="primary" elevation="10">See More</v-btn>
        <v-btn disabled>Disabled</v-btn>
            </v-card-actions>
        </v-card>
        
  
    </v-container>
</div>
</template>

<script>
export default {
    name: 'about',

};
</script>

<style>

</style>