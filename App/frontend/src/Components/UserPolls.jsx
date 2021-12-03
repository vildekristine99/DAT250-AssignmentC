import React from "react";
import AuthService from "../Service/auth.service.js";
import { useEffect, useState } from "react";
import lineImage from "../logos/userPollsLine.svg";
import { useHistory } from "react-router-dom";

const UserPolls = () => {
  const [pollArray, setPollArray] = useState([]);
  const history = useHistory();

  useEffect(() => {
    setPollArray(AuthService.getCurrentUser().polls);
    console.log(pollArray);
  }, []);

  const checkPolls = () => {
    if (pollArray !== null) {
      return (
        <div>
          <div className="lineWrapPoll">
            <img src={lineImage} class="imageline1" alt="line" />
            <p>My polls</p>
            <img src={lineImage} class="imageline1" alt="line" />
          </div>
        </div>
      );
    } else {
      return <p>You have no polls</p>;
    }
  };

  const handleClick = (value) => {
    console.log(value);
    history.push({
      pathname: "/pollResult",
      state: value,
    });
    //history.push("/viewPoll", value);
    console.log(value);
    //window.location.reload();
  };

  return (
    <div className="inputDiv">
      {checkPolls()}

      {pollArray.length && (
        <div className="polls">
          {pollArray.map((value, index) => {
            return (
              <div className="poll" onClick={() => handleClick(value)}>
                <p key={index}>{value.pollName}</p>
              </div>
            );
          })}
        </div>
      )}
      <a href="/#/userHome" className="loginReg">
        Go back
      </a>
    </div>
  );
};

export default UserPolls;
