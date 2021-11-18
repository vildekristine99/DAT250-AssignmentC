import axios from 'axios'
import authHeader from './auth-header.js'
const API_URL = 'http://localhost:8080/vote';

class VoteService {

    getVoteBoard() {
        return axios.get(API_URL, { headers: authHeader() });
    }

    
}

export default new VoteService();