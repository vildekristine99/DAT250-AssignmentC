import axios from 'axios'
import authHeader from './auth-header'
//const POLLUSER_REST_API = 'http://localhost:8080/users';
const API_URL = 'http://localhost:8080/api/test/';

class PollUserService {

    getPollUsersBoard() {
        return axios.get(API_URL + 'user', { headers: authHeader() });
    }

    getLoginContent() {
        return axios.get(API_URL + 'all');
    }
}

export default new PollUserService();