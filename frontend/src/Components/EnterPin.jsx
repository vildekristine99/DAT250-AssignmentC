import React from "react";
import PollUserService from "../Service/PollUserService";
import PollUsers from "../API/PollUsers";


//class EnterPin extends React.Component {

    const EnterPin = () => {
        return (
            <div className="pinInputDiv">
                <p>Get your voting on! </p>
                <input className="pinInput" type="text" placeholder="Enter pin..."/>
                <PollUsers></PollUsers>
            </div>
        )
    }
    


export default EnterPin;