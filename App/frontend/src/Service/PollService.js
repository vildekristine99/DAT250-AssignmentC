import axios from 'axios'
import authHeader from './auth-header.js'
const API_URL = 'http://localhost:8080/api/polls';

class PollService {

    getPollUsersBoard() {
        return axios.get(API_URL, { headers: authHeader() });
    }

    getPoll(id) {
        return axios.get(API_URL + "/" + id)
        .then(response => {
            if (response) {
                localStorage.setItem("poll", JSON.stringify(response.data))
            } 
            return response.data;
        })
        .catch(err => console.log(err))
    }

    getCurrentPoll() {
        return JSON.parse(localStorage.getItem('poll'));
    }

    closePoll() {
        localStorage.removeItem("poll");
    }

    createPoll(pollName, isPublic, userId){
        return axios.post('http://localhost:8080/api/poll', {
        "pollName":pollName,
        "isPublic":isPublic,
        "pollUser":{"userId":userId},
        "votes":[]
        });
    }

    dweetInit(pollName, name) {
        return axios.post('https://dweet.io/dweet/for/Votesphere?pollName='+pollName+"&creator="+name);
    }
    
}

export default new PollService();