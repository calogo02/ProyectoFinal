import { createStore } from 'vuex'

export default createStore({
  state: {
    token: null
  },
  getters: {
    setToken(state, payload) {
      state.token = payload;
    }
  },
  mutations: {
  },
  actions: {
    cerrarSesion({commit}){
      commit("setToken", null);
    }
  },
  modules: {
  }
})
