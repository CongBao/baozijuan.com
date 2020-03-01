import axios from 'axios'

const _axios = axios.create();

// Full config:  https://github.com/axios/axios#request-config
_axios.defaults.baseURL = 'http://localhost:8888/rest';
_axios.defaults.timeout = 60 * 1000;
_axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

_axios.interceptors.request.use(
  function(config) {
    return config;
  },
  function(error) {
    return Promise.reject(error);
  }
);

_axios.interceptors.response.use(
  function(response) {
    return {
      code: response.status,
      text: response.statusText,
      body: response.data
    };
  },
  function(error) {
    return Promise.reject(error);
  }
);

export default _axios;