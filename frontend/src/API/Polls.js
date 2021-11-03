import React from 'react'

class Polls extends React.Component {

    
    constructor(props) {
        super(props);
        this.state = {
          error: null,
          isLoaded: false,
          polls: []
        };
      }
    
      componentDidMount() {
        fetch("http://localhost:8080/users")
          .then(res => res.json())
          .then(
            (result) => {
              this.setState({
                isLoaded: true,
                polls: result//hente fra een person
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
        const { error, isLoaded, polls } = this.state;
        if (error) {
          return <div>Error: {error.message}</div>;
        } else if (!isLoaded) {
          return <div>Loading...</div>;
        } else {
          return (
            <div>
                <ul>
                {polls.map(poll => (
                    <li key={poll.userId}>
                    {poll.username} {poll.firstname} {poll.lastname}
                    </li>
                ))}
                </ul>
            </div>
          );
        }
      }
    
    
}

export default Polls;