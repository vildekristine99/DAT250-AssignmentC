import React from "react";
import { useEffect, useState } from "react";
import PollService from "../Service/PollService";
import VoteService from "../Service/VoteService";

const ViewPoll = () => {
    const [pollname, setPollname] = useState();
    const [pollId, setPollId] = useState();

    useEffect(() => {
      setPollname(PollService.getCurrentPoll().pollName);
      console.log(pollname);
      setPollId(PollService.getCurrentPoll().pollId);
      console.log(pollId);
    }, []);

    const postVote = (props) => {
      console.log(props)
      VoteService.addVote(pollId, props);
      
    }
 
    return (
      <div className="inputDiv">
      <div className="viewpoll">
        <p>{pollname}</p>
        <div className="btns-wrapper">
          <button className="btns" value="true" name="yes" onClick={() => {postVote(true)}}> Yes </button>
          <button className="btns" value="false" name="no" onClick={() => {postVote(false)}}>No </button>
        </div>
      </div>
      <a href="/#" className="loginReg">
        Go back
      </a>
    </div>
  );
};

export default ViewPoll;
