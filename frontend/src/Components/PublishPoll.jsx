import React from "react"; 

const PublishPoll = () => {

    return (
    <div className="inputDiv">
            <p className="descriptionBig"> Poll description</p>
            <input className="largeInput" type="text" placeholder="...(max 250 characters)" />

            <div className="radioDiv">
                <input className="radio" type="radio" id="radio1" value="Public" checked />
                <label className="labelRadio" for="radio1">Public</label>

                <input className="radio" type="radio" id="radio2" value="Private" />
                <label className="labelRadio" for="radio2">Private</label>
            </div>
        

        <button className="blackButton"> Publish Poll </button>
        <p> Cancel </p>
    </div>

    );

}
export default PublishPoll; 


