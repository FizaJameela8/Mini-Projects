import React from 'react'
import Left from './Left'
import Right from './Right'

function Content(props) {
  return (
    <div className='flex p-5 gap-3'>
       <Left />
       <Right users={props.users} />
    </div>
  )
}

export default Content