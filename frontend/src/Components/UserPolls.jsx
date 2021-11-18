import React from "react";
import AuthService from "../Service/auth.service.js";
import { useEffect, useState } from "react";

const UserPolls = () => {
  const [pollArray, setPollArray] = useState([]);

  useEffect(() => {
    setPollArray(AuthService.getCurrentUser().polls);
    console.log(pollArray);
  }, []);

  const checkPolls = () => {};

  return (
    <div>
      {!!pollArray.length && (
        <div className="inputDiv">
          {pollArray.map((value, index) => {
            return <p key={index}>{value.pollName}</p>;
          })}
        </div>
      )}
    </div>
  );
};

/*
class UserPolls extends React.Component {
    
    constructor(props) {
        super(props)

        this.state = {
            polls:[] ,
        }

        this.handleChange = this.handleChange.bind(this)
        this.publishButtonClicked = this.publishButtonClicked.bind(this)
    }

    /*receivePolls() {
        AuthService.getCurrentUser().
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
        
                <button className="blackButton">{ {poll.name} }</button>
                
                <p>Go back</p>
            </div>
        );
    }
    
}*/

export default UserPolls;
