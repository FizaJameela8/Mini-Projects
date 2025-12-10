import React from 'react'
import Nav from './Nav'
import Content from './Content'

function Section1(props) {
  return (
    <div id="section1">
       <Nav/>
       <Content users={props.users} />
    </div>
  )
}

export default Section1