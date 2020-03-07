import authService from '../service/auth.service'

const user = JSON.parse(localStorage.getItem('user'));
const initState = user
  ? {status: {loggedIn: true}, user}
  : {status: {loggedIn: false}, user: null};

export const auth = {
  namespaced: true,
  state: initState,
  actions: {
    async login({commit}, user) {
      try {
        const data = await authService.login(user);
        commit('loginSuccess', data);
        return Promise.resolve(data);
      }
      catch (error) {
        commit('loginFailure');
        return Promise.reject(error);
      }
    },
    logout({commit}) {
      authService.logout();
      commit('logout');
    },
    async register({commit}, user) {
      try {
        const data = await authService.register(user);
        commit('registerSuccess', data);
        return Promise.resolve(data);
      }
      catch (error) {
        commit('registerFailure');
        return Promise.reject(error);
      }
    }
  },
  mutations: {
    loginSuccess(state, user) {
      state.status.loggedIn = true;
      state.user = user;
    },
    loginFailure(state) {
      state.status.loggedIn = false;
      state.user = null;
    },
    logout(state) {
      state.status.loggedIn = false;
      state.user = null;
    },
    registerSuccess(state, user) {
      state.status.loggedIn = true;
      state.user = user;
    },
    registerFailure(state) {
      state.status.loggedIn = false;
      state.user = null;
    }
  }
}