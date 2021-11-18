import React, { useState } from "react";
import PollUserService from "../Service/PollUserService.js";
import PollUsers from "../API/PollUsers.js";
import PollService from "../Service/PollService.js";
import { useHistory } from "react-router";

//class EnterPin extends React.Component {

const EnterPin = () => {
  const [pin, setPin] = useState("");
  const history = useHistory();

  const buttonClicked = () => {
    history.push({
      pathname: "/viewPoll",
      state: PollService.getPoll(pin),
    });
    window.location.reload();
  };

  const buttonCheck = () => {
    history.push("/viewPoll");
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
      <button className="loginButton" onClick={() => buttonCheck()}>
        Enter pin
      </button>
    </div>
  );
};

export default EnterPin;
