import { ListGroup } from 'react-bootstrap'
import TaskItem from './TaskItem'

function TaskList({ tasks, onToggleComplete, onDelete }) {
  return (
    <ListGroup variant="flush">
      {tasks.map((task) => (
        <ListGroup.Item key={task.id}>
          <TaskItem
            task={task}
            onToggleComplete={onToggleComplete}
            onDelete={onDelete}
          />
        </ListGroup.Item>
      ))}
    </ListGroup>
  )
}

export default TaskList