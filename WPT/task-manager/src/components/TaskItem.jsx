import { Form, Badge, Card, Stack, Button } from 'react-bootstrap'
import { Link } from 'react-router-dom'
import { format } from 'date-fns'

function TaskItem({ task, onToggleComplete, onDelete }) {
  const priorityVariant = {
    low: 'success',
    medium: 'warning',
    high: 'danger'
  }

  return (
    <Card className="mb-3">
      <Card.Body>
        <div className="d-flex justify-content-between align-items-start">
          <div>
            <Card.Title className="d-flex align-items-center gap-2">
              <Form.Check
                type="checkbox"
                checked={task.completed}
                onChange={() => onToggleComplete(task.id)}
                className="me-2"
              />
              <Link to={`/tasks/${task.id}`} className="text-decoration-none">
                {task.title}
              </Link>
            </Card.Title>
            <Card.Text>{task.description}</Card.Text>
          </div>
          <Badge bg={priorityVariant[task.priority]} className="text-capitalize">
            {task.priority}
          </Badge>
        </div>
        <Stack direction="horizontal" gap={3} className="mt-2">
          {task.dueDate && (
            <small className="text-muted">
              Due: {format(new Date(task.dueDate), 'MMM dd, yyyy')}
            </small>
          )}
          <Button
            variant="outline-danger"
            size="sm"
            onClick={() => onDelete(task.id)}
            className="ms-auto"
          >
            Delete
          </Button>
        </Stack>
      </Card.Body>
    </Card>
  )
}

export default TaskItem