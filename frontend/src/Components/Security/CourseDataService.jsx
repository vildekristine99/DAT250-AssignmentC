import axios from 'axios'

const USER = 'in28minutes'
const PASSWORD = 'dummy'
const API_URL = 'http://localhost:8080'
const POLL_API_URL = `${COURSE_API_URL}/polls/${USER}`

class CourseDataService {

    retrieveAllCourses(name) {
        console.log('executed service')
        return axios.get(`${POLL_API_URL}/users`,
            { headers: { authorization: 'Basic ' + window.btoa(USER + ":" + PASSWORD) } }
        );
    }
}

export default new CourseDataService()