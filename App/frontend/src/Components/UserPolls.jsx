import React from "react";
import AuthService from "../Service/auth.service.js";
import { useEffect, useState } from "react";
import lineImage from "../logos/userPollsLine.svg";

const UserPolls = () => {
  const [pollArray, setPollArray] = useState([]);

  useEffect(() => {
    setPollArray(AuthService.getCurrentUser().polls);
    console.log(pollArray);
  }, []);

  const checkPolls = () => {
    if (pollArray.length > 0) {
      return (
        <div>
          <img src={lineImage} class="imageline1" alt="line" />
          <p>My polls</p>
          <img src={lineImage} class="imageline1" alt="line" />
        </div>
      );
    } else {
      return <div>You have no polls</div>;
    }
  };

  return (
    <div className="inputDiv">
      {checkPolls}

      {!!pollArray.length && (
        <div className="poll">
          {pollArray.map((value, index) => {
            return <p key={index}>{value.pollName}</p>;
          })}
        </div>
      )}
      <a href="/#/userHome" className="loginReg">
        Go back
      </a>
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
