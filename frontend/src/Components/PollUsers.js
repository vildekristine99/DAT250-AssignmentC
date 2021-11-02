import React from 'react'

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
        fetch("http://localhost:8080/users")
          .then(res => res.json())
          .then(
            (result) => {
              this.setState({
                isLoaded: true,
                pollUsers: result.pollUsers
              });
            },
            // Note: it's important to handle errors here
            // instead of a catch() block so that we don't swallow
            // exceptions from actual bugs in components.
            (error) => {
              this.setState({
                isLoaded: true,
                error
              });
            }
          )
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