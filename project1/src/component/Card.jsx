import React from 'react'
import { Bookmark } from 'lucide-react'

function Card(props) {
    return (
        <>
            <div className="card">

                <div className='top'>
                    <img src={props.logo}></img>
                    <button>Save<Bookmark /> </button>
                </div>

                <div className='center'>
                    <p><b>{props.company}</b><span>{props.datePosted}</span></p>
                    <p><b>{props.title}</b></p>
                    <div id="b">
                         <p className='bl'>{props.jobType}</p>
                         <p className='bl'>{props.seniority}</p>
                    </div>
                </div>
                
                <div className='bottom'>

                    <div className='line'>
                    <div>
                         <div>
                             <hr></hr>
                         </div>

                    </div>
                    <div className='twoblock'>
                    <div>
                        <p><b>{props.pay}</b></p>
                        <p>{props.location}</p>
                    </div>

                    <div>
                        <button className='apply'>Apply</button>
                    </div>

                   </div>
                    </div>
                </div>
                <p></p>
            </div>

        </>
    )
}

export default Card