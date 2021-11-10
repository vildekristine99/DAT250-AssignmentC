import React from "react";

class UserPolls extends React.Component {
    
    constructor(props) {
        super(props)

        this.state = {
            polls:[] ,
        }

        this.handleChange = this.handleChange.bind(this)
        this.publishButtonClicked = this.publishButtonClicked.bind(this)
    }
   

    handleChange(event) {
        this.setState(
            {
                [event.target.name]
                    : event.target.value
            }
        )
        console.log(event.target.value)
    }

    
    publishButtonClicked() {

    }

    render() {
        return (
            <div className="inputDiv">
                <p>My polls</p>
        
                <button className="blackButton">{/* {poll.name} */}</button>
                
                <p>Go back</p>
            </div>
        );
    }
    
}

export default UserPolls;