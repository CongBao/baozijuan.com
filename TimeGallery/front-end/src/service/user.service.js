import axios from '../config/axios.config'
import ServiceError from './error.service'

class UserService {

  constructor() {
    this.user = JSON.parse(localStorage.getItem('user'));
    if (!this.user) {
      throw new ServiceError('User not found.');
    }
    this.id = this.user.id;
    this.config = {headers: {Authorization: `Bearer ${this.user.token}`}};
  }

  async get() {
    const response = await axios.get(`/user/${this.id}`, this.config);
    return response.body;
  }

  async updateUsername(username) {
    const response = await axios.put(`/user/${this.id}/username`, username, this.config);
    return response.body;
  }

  async updatePassword(password) {
    const response = await axios.put(`/user/${this.id}/password`, password, this.config);
    return response.body;
  }

}

export default new UserService();
