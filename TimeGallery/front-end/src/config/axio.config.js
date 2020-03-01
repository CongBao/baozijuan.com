import axios from 'axios'

const _axios = axios.create();

// Full config:  https://github.com/axios/axios#request-config
_axios.defaults.baseURL = 'http://localhost:8888/rest';
_axios.defaults.timeout = 60 * 1000;
_axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

_axios.interceptors.request.use(
  function(config) {
    // Do something before request is sent
    return config;
  },
  function(error) {
    // Do something with request error
    return Promise.reject(error);
  }
);

// Add a response interceptor
_axios.interceptors.response.use(
  function(response) {
    // Do something with response data
    return response;
  },
  function(error) {
    // Do something with response error
    return Promise.reject(error);
  }
);

export default _axios;