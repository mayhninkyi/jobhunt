import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    isRegister: false,
    userInfo: {},

  },
  getters: {
    isRegister: (state) => {
      return state.isRegister;
    },
    userInfo: (state) => {
      return state.userInfo;
    },
  },
  mutations: {
    setIsRegister(state,isRegister) {
      state.isRegister = isRegister;
    },
    setUserInfo(state,userInfo) {
      state.userInfo = userInfo;
    },

  },
  actions: {
  },
  modules: {
  }
})
