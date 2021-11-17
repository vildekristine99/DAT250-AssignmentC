import React from 'react'
import PollUserService from "../Service/PollUserService";

class PollUsers extends React.Component {


    constructor(props) {
        super(props);
        this.state = {
            error: null,
            isLoaded: false,
            pollUsers: []
        };
    }

    componentDidMount() {
        PollUserService.getPollUsersBoard().then(response => {
            console.log("Data loaded successfully:");
            console.log(response);
        });
        // TODO: Use the data contained in the response (works after registering and logging in)
    }

    render() {
        const { error, isLoaded, pollUsers } = this.state;
        if (error) {
            return <div>Error: {error.message}</div>;
        } else if (!isLoaded) {
            return <div>Loading...</div>;
        } else {
            return (
                <div>
                    <ul>
                        {pollUsers.map(pollUser => (
                            <li key={pollUser.userId}>
                                {pollUser.username} {pollUser.firstname} {pollUser.lastname}
                            </li>
                        ))}
                    </ul>
                </div>
            );
        }
    }


}

export default PollUsers;