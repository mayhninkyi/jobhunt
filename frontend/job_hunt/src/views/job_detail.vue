<template>
    <div class="my-5 container">
        <!-- Company profile, Job Info -->
        <v-row class="ma-0">
            <!-- Company profile image -->
            <v-col cols="3" class="ma-0 pa-0">
                <v-img class="ma-0" :src="image" contain></v-img>
            </v-col>

            <!-- Job Info -->
            <v-col cols="7">
                <div class="text-h3">{{ job.title }}</div>
                <div class="text-caption ml-2 my-2">{{ job.category.name }}</div>
                <div class="text-body-1 ml-2 my-2">{{ job.salary }} Kyat</div>
                <div v-show="job.isCloseJob" class="text-body-1 ml-2 my-2">Closed</div>
                <v-card class="text-body-1 ml-1 my-2 pa-2">
                    <v-card-title>{{ job.company.name }}</v-card-title>
                    <v-card-text>{{ job.company.about }}</v-card-text>
                    <v-card-title>Description</v-card-title>
                    <v-card-text>{{ job.description }}</v-card-text>
                    <v-card-title>Requirement</v-card-title>
                    <v-card-text>{{ job.requirement }}</v-card-text>
                    <v-card-title>No of Employee</v-card-title>
                    <v-card-text>{{ job.noOfEmployee }}</v-card-text>
                    <!-- Apply Btn -->
                    <v-btn :disabled="alreadyApply" color="blue-grey darken-3 white--text" class="mr-4"
                        @click="goToApplyJob()">
                        <span>{{ btnText }}</span>
                    </v-btn>
                </v-card>
            </v-col>
        </v-row>


    </div>
</template>

<script>
import utils from "../utils/utils";

export default {

    data() {
        return {
            localDomain: utils.constant.localDomain,

            loginUser: {},

            // Job ID from Path
            job_id: this.$route.params.id,
            job: {},
            alreadyApply: false,
            btnText: "APPLY JOB",
            image: "https://image.shutterstock.com/image-photo/beautiful-cosmos-flowers-blooming-garden-260nw-797194879.jpg"

        };
    },

    async created() {
        // LoginUser from Vuex
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

        await this.fetchJob();
        await this.fetchAlreadyApplied();
    },

    methods: {

        async fetchAlreadyApplied() {
            console.log(this.loginUser.id);
            console.log(this.job_id);
            const resp = await utils.http.post("/api/checkApplyJob", {
                userId: this.loginUser.id,
                jobId: this.job_id,
            });
            if (resp && resp.status === 200) {
                this.alreadyApply = await resp.text();
                if (this.alreadyApply) {
                    this.btnText = "APPLIED";
                }
            }

        },
        async fetchJob() {
            const resp = await utils.http.get("/api/job/" + this.job_id);
            if (resp && resp.status === 200) {
                const data = await resp.json();
                if (data) {
                    this.job = data;
                }
            }
        },
        goToApplyJob() {
            this.$router.push({
                path: "/applyJob/" + this.job_id,
            });
        },

    },
};
</script>

<style scoped>
.container {
    margin-left: 10vw !important;
    margin-right: 10vw !important;
}
</style>
