import React from 'react'

class PollUsers extends React.Component {

    
    constructor(props) {
        super(props)
        this.state = {
            pollUsers:[]
        }
    }


    componentDidMount() {
        
        this.getPollUsers()
        /*PollUserService.getPollUsers()
            .then(response => {
                this.setState({ users: response.data })
            })*/
    }

    render() {
        return (
            <div>
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <td>User Id</td>
                            <td>Username</td>
                        </tr>
                    </thead>

                    <tbody>

                        {
                            this.state.pollUsers.map(
                                pollUser =>
                                <tr key={pollUser.id}>
                                    <td>{pollUser.id}</td>
                                    <td>{pollUser.question}</td>
                                </tr>
                            )
                        }

                    </tbody>
                </table>
            </div>
        )
    }
    async getUsers() {
        const response = await fetch("/users")
        const data = await response.json()
        this.setState({ users: data })
    }
    
}

export default PollUsers;