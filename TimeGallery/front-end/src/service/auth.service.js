import axios from '../config/axios.config'
import qs from 'qs'

class AuthService {

  async login(user) {
    const response = await axios.post('/auth/login', qs.stringify(user));
    console.log(response);
    if (response.body.status.code == 200) {
      localStorage.setItem('user', JSON.stringify(response.body.data));
    }
    return response.body;
  }

  logout() {
    localStorage.removeItem('user');
  }

}

export default new AuthService()