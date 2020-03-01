import axios from '../config/axio.config'
import qs from 'qs'

class AuthService {

  async login(user) {
    const response = await axios.post('/auth/login', qs.stringify(user));
    if (response.data.status.code == 200) {
      localStorage.setItem('user', JSON.stringify(response.data.data));
    }
    return response.data;
  }

}

export default new AuthService()