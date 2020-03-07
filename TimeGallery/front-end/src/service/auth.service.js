import axios from '../config/axios.config'
import qs from 'qs'

class AuthService {

  async login(user) {
    const response = await axios.post('/auth/login', qs.stringify(user));
    if (response.body.status.code == 200) {
      localStorage.setItem('user', JSON.stringify(response.body.data));
    }
    return response.body;
  }

  logout() {
    localStorage.removeItem('user');
  }

  async register(user) {
    const config = {headers: {'Content-Type': 'application/json'}}
    const response = await axios.post('/auth/register', user, config);
    return response.body;
  }

}

export default new AuthService()