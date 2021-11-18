import React, { useState, useEffect } from "react";
import PollUserService from "../Service/PollUserService.js";
import PollUsers from "../API/PollUsers.js";
import PollService from "../Service/PollService.js";
import { useHistory } from "react-router";

//class EnterPin extends React.Component {

const EnterPin = () => {
  const [pin, setPin] = useState("");
  const history = useHistory();

  useEffect(() => {
    PollService.closePoll();
  }, []);

  const buttonClicked = () => {
    PollService.getPoll(pin);
    history.push({
      pathname: "/viewPoll"});
    window.location.reload();
  };

  return (
    <div className="inputDiv">
      <p>Get your voting on! </p>
      <input
        className="pinInput"
        type="text"
        value={pin}
        onInput={(e) => setPin(e.target.value)}
        placeholder="Enter pin..."
      />
      <button className="loginButton" onClick={() => buttonClicked()}>
        Enter pin
      </button>
    </div>
  );
};

export default EnterPin;
