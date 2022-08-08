import org.junit.Assert.*
import org.junit.Test

class WallServiceTest {
    @Test
    fun addNewPost() {
        val expectedId = 1
        val service = WallService<Post>()
        val newPost = service.add(Post(1, 234, "Hello", 24, true, true, Comment(1, 111, "nice comment", 0), true, null,null,null,null));
        assertEquals(newPost.id, expectedId)
    }

    @Test
    fun updateExisting() {
        // создаём целевой сервис
        val service = WallService<Post>()
        // заполняем несколькими постами
        service.add(Post(2, 234, "Hello", 24, true, true, Comment(1, 111, "nice comment", 0), true, null,null,null,null));
        service.add(Post(3, 666, "Yes yes", 25, false, true, Comment(2, 222, "nice comment!!", 0), true, null,null,null,null));
        service.add(Post(4, 777, "Hello all", 26, true, true, Comment(3, 333, "nice comment", 0), true, null,null,null,null));
        val update = Post(2, 999, "Yes and not now", 27, false, true, Comment(1, 111, "nice comment", 0), true, null,null,null,null)

        // выполняем целевое действие
        val result = service.update(update)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertTrue(result)
    }

    @Test
    fun updateNotExisting() {
        // создаём целевой сервис
        val service = WallService<Post>()
        // заполняем несколькими постами
        service.add(Post(111, 234, "Hello", 24, true, true, Comment(1, 111, "nice comment", 0), true, null,null,null, null));
        service.add(Post(112, 666, "Yes yes", 25, false, true, Comment(2, 222, "nice comment!!", 0), true, null,null,null, null));
        service.add(Post(113, 777, "Hello all", 26, true, true, Comment(3, 333, "nice comment", 0), true, null,null,null, null));
        val update = Post(114, 999, "Yes and not now", 27, false, true, Comment(1, 111, "nice comment", 0), true, null,null,null, null)

        // выполняем целевое действие
        val result = service.update(update)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertFalse(result)
    }

    @Test(expected = CommentExeption::class)
    fun getByID_notListIDNotEquals() {
        val service = WallService<Post>()
        val post1 = Post(1, 234, "Hello", 24, true, true, Comment(1, 111, "nice comment", 0), true, null,null,null, null);
        val post2 = Post(2, 234, "Hello", 24, true, true, Comment(1, 111, "nice comment", 0), true, null,null,null, null);
        service.add(post1)
        service.add(post2)
        service.getByID(4)
    }

    @Test
    fun getByID_itIsOK() {
        val service = WallService<Post>()
        val post1 = Post(1, 234, "Hello", 24, true, true, Comment(1, 111, "nice comment", 0), true, null,null,null, null);
        val post2 = Post(2, 234, "Hello", 24, true, true, Comment(1, 111, "nice comment", 0), true, null,null,null, null);
        service.add(post1)
        service.add(post2)
        service.getByID(1)
    }

    @Test(expected = CommentExeption::class)
    fun createComment_notCreateIDNotEquals() {
        val service = WallService<Post>()
        val post1 = Post(1, 234, "Hello", 24, true, true, Comment(1, 111, "nice comment", 0), true, null,null,null, null);
        val post2 = Post(2, 234, "Hello", 24, true, true, Comment(1, 111, "nice comment", 0), true, null,null,null, null);
        service.add(post1)
        service.add(post2)
        val comm1 = Comment(9,1,"Nice text!",0)
        service.createComment(comm1)
    }

    @Test
    fun createComment_itIsOK() {
        val service = WallService<Post>()
        val post1 = Post(1, 234, "Hello", 24, true, true, Comment(1, 111, "nice comment", 0), true, null,null,null, null);
        val post2 = Post(2, 234, "Hello", 24, true, true, Comment(1, 111, "nice comment", 0), true, null,null,null, null);
        service.add(post1)
        service.add(post2)
        val comm1 = Comment(1,1,"Nice text!",0)
        service.createComment(comm1)
    }
}