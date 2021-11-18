import axios from 'axios'
import authHeader from './auth-header.js'
const API_URL = 'http://localhost:8080/api/vote';

class VoteService {

    getVoteBoard() {
        return axios.get(API_URL, { headers: authHeader() });
    }

    addVote(pollId, value){
        return axios.post(API_URL + "/newVote", {
            "poll":{"pollId":pollId},
            "value": value
        });
    }
    

}

export default new VoteService();