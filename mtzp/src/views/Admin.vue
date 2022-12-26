<template>
  <div>
    <h1>Welcome to Home Screen</h1>
    <p> heyllllllfffff</p>
     <!-- 1.Text Interporation -->
     <!-- 2.Data Building -->
     <!-- 3.Event Building -->
    <p class ='my-p'>{{userName}}</p>
    <h3>{{count}}</h3>
    <h3>{{count == 5?  'Is 5':'default'}}</h3>
    <button  :disabled='isBtndisable' @click='countUp()'>Count Up</button>
    <MyButton></MyButton>

  </div>
</template>

<script>
import MyButton from '@/components/MyButton.vue';

 export default {
    //Screen Name
    name: 'admin',

    //Use Components
    components:{
        MyButton
         

    },

    //Variables
    data() {
        return{
            userName: 'Mg Mg',
            count: 0,
            isBtndisable: false,
        };
    },
    //Run when open first screen
    created(){
        console.log('Open Home Screen');
    },
    //Methods
    methods:{
        // countUp(num = 0){
        //     num++;
        //     console.log(num);
        //     return num;

        // },
        countUp(){
            this.count++;
        },

    },
    
};
</script>
<style scoped>
button {
    padding: 30px;
    color: green;
    text-decoration: underline;
}
.my-p {
    color: brown;
    padding: 50px;
}
</style>
 

  




