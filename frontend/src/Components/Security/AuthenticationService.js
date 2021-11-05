import React from 'react';
import axios from 'axios';

const API_URL = 'http://localhost:8080'

class AuthenticationService {

    
    executeBasicAuthenticationService(username, password) {
        return axios.get('http://localhost:8080/basicauth',
            { headers: { authorization: this.createBasicAuthToken(username, password) } })
    }

    createBasicAuthToken(username, password) {
        return 'Basic ' + window.btoa(username + ":" + password)
    }//julil
}

export default AuthenticationService