import React from "react";
import { useEffect, useState } from "react";
import PollService from "../Service/PollService";
import VoteService from "../Service/VoteService";

const ViewPoll = () => {
    const [pollname, setPollname] = useState();
    const [pollId, setPollId] = useState();

    useEffect(() => {
      setPollname(PollService.getCurrentPoll().name);
      console.log(pollname);
      setPollId(PollService.getCurrentPoll().pollId);
      console.log(pollId);
    }, []);

    const postVote = (vote) => {
      VoteService.addVote(pollId, vote);
      
    }
 
    return (
      <div className="inputDiv">
      <div className="viewPoll">
        <p>{pollname}</p>
        <div className="btns-wrapper">
          <button className="btns" value="true" name="vote" onClick={postVote()}> Yes </button>
          <button className="btns" value="false" name="vote" onClick={postVote()}>No </button>
        </div>
      </div>
      <a href="/#/userPolls" className="loginReg">
        Go back
      </a>
    </div>
    );
}

export default ViewPoll;