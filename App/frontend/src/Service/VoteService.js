import axios from 'axios'
import authHeader from './auth-header.js'
const API_URL = 'http://localhost:8080/vote';

class VoteService {

    getVoteBoard() {
        return axios.get(API_URL, { headers: authHeader() });
    }

    addVote(pollId, vote){
        return axios.post(API_URL + "newVote", {
        pollId,
        vote
      });
    }
//to pollservice
    getCurrentPoll() {
        return JSON.parse(localStorage.getItem('poll'));
    }
}

export default new VoteService();